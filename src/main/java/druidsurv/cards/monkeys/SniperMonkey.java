package druidsurv.cards.monkeys;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.powers.Reload;

import static druidsurv.ModFile.makeID;

public class SniperMonkey extends AbstractEasyCard {
    public final static String ID = makeID("Sniper");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public SniperMonkey() {
        super(ID, 1, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY, "SniperMonkey_CardArt");
        baseDamage = 12;
        tags.add(druidsurv.cards.cardvars.CardTags.RELOAD);
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        this.exhaust = true;
        this.setCardBack(cardSubType.MONKEY);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        dmg(m, AbstractGameAction.AttackEffect.BLUNT_HEAVY);
        addToBot((AbstractGameAction)new ApplyPowerAction(p, p, (AbstractPower)new Reload(p, 1), 1, true, AbstractGameAction.AttackEffect.NONE));

    }

    @Override
    public void upp() {
        upgradeDamage(3);
    }
}