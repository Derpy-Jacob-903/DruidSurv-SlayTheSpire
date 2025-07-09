package druidsurv.cards.monkeys;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.powers.Reload;

import static druidsurv.ModFile.makeID;

public class CripplingMonkey extends AbstractEasyCard {
    public final static String ID = makeID("CripplingSniper");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public CripplingMonkey() {
        super(ID, 3, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY, "CripplingSniper_CardArt");
        baseDamage = 30;
        tags.add(druidsurv.cards.cardvars.CardTags.RELOAD);
        tags.add(druidsurv.cards.cardvars.CardTags.UNIQUE);
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        this.exhaust = true;
        this.setCardBack(cardSubType.MONKEY);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        dmg(m, AbstractGameAction.AttackEffect.BLUNT_HEAVY);
        addToBot((AbstractGameAction)new ApplyPowerAction(m, p, (AbstractPower)new VulnerablePower(m, 5, false), 5, true, AbstractGameAction.AttackEffect.NONE));
        addToBot((AbstractGameAction)new ApplyPowerAction(p, p, (AbstractPower)new Reload(p, 1), 1, true, AbstractGameAction.AttackEffect.NONE));
    }

    @Override
    public void upp() {
        upgradeDamage(3);
    }
}