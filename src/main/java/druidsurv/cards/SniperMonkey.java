package druidsurv.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.powers.reload;

import static druidsurv.ModFile.makeID;

public class SniperMonkey extends AbstractEasyCard {
    public final static String ID = makeID("Sniper");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public SniperMonkey() {
        super(ID, 2, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = 25;
        tags.add(druidsurv.cards.cardvars.CardTags.RELOAD);
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        this.exhaust = true;
        setBackgroundTexture("druidsurvResources/images/512/monkey_attack.png", "druidsurvResources/images/1024/monkey_attack.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        dmg(m, AbstractGameAction.AttackEffect.BLUNT_HEAVY);
        addToBot((AbstractGameAction)new ApplyPowerAction(p, p, (AbstractPower)new reload(p, 1), 1, true, AbstractGameAction.AttackEffect.NONE));

    }

    @Override
    public void upp() {
        upgradeDamage(3);
    }
}