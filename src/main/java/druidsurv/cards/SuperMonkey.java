package druidsurv.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.powers.Prized;
import druidsurv.powers.reload;

import static druidsurv.ModFile.makeID;

public class SuperMonkey extends AbstractEasyCard {
    public final static String ID = makeID("SuperMonkey");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public SuperMonkey() {
        super(ID, 3, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);
        baseDamage = 18;
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        this.isEthereal = true;

        setBackgroundTexture("druidsurvResources/images/512/monkey_attack.png", "druidsurvResources/images/1024/monkey_attack.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        addToBot((AbstractGameAction)new ApplyPowerAction(p, p, (AbstractPower)new Prized(p, 6), 6, true, AbstractGameAction.AttackEffect.NONE));
        dmg(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
        dmg(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
        dmg(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
    }

    @Override
    public void upp() {
        upgradeDamage(9);
    }
}